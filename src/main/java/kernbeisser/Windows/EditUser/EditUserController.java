package kernbeisser.Windows.EditUser;

import at.favre.lib.crypto.bcrypt.BCrypt;
import kernbeisser.DBEntities.User;
import kernbeisser.DBEntities.UserGroup;
import kernbeisser.Enums.Mode;
import kernbeisser.Enums.PermissionKey;
import kernbeisser.Enums.Setting;
import kernbeisser.Exeptions.CannotParseException;
import kernbeisser.Security.Proxy;
import kernbeisser.Useful.Tools;
import kernbeisser.Windows.MVC.IController;
import org.jetbrains.annotations.NotNull;

public class EditUserController implements IController<EditUserView, EditUserModel> {
  private EditUserView view;
  private final EditUserModel model;

  public EditUserController(User user, Mode mode) {
    model = new EditUserModel(user == null ? Proxy.getSecureInstance(new User()) : user, mode);
    if (mode == Mode.REMOVE) {
      Tools.delete(user);
    }
  }

  @Override
  public @NotNull EditUserModel getModel() {
    return model;
  }

  @Override
  public void fillUI() {
    view.getObjectForm().setSource(getModel().getUser());
    view.getObjectForm().setObjectValidator(this::validateUser);
  }

  private User validateUser(User user) throws CannotParseException {
    if (model.getMode() == Mode.ADD) {
      user.setPassword(
          BCrypt.withDefaults()
              .hashToString(Setting.HASH_COSTS.getIntValue(), "start".toCharArray()));
      user.setForcePasswordChange(true);
      user.setUserGroup(new UserGroup());
      Tools.persist(user.getUserGroup());
    }
    return user;
  }

  @Override
  public PermissionKey[] getRequiredKeys() {
    return new PermissionKey[] {
      PermissionKey.USER_USERNAME_READ,
    };
  }

  void doAction() {
    if (view.getObjectForm().applyMode(model.getMode())) {
      view.back();
    }
  }

  void refreshUsername() {
    if (model.getMode() == Mode.ADD) {
      User data = view.getObjectForm().getDataIgnoreWrongInput();
      if (data.getSurname() != null && data.getFirstName() != null) {
        view.setUsername(
            model
                .generateUsername(
                    data.getFirstName().toLowerCase().replace(" ", ""),
                    data.getSurname().toLowerCase())
                .replace(" ", ""));
      }
    }
  }

  public String validateUsername(String s) throws CannotParseException {
    switch (model.getMode()) {
      case EDIT:
        if (model.getUser().getUsername().equals(s)) {
          return s;
        }
      case ADD:
        if (model.usernameExists(s)) {
          view.usernameAlreadyExists();
          throw new CannotParseException("username already exists");
        } else return s;
      default:
        throw new UnsupportedOperationException(
            model.getMode() + "is not a supported mode for this form");
    }
  }
}

package kernbeisser.Windows.ManageUser;

import kernbeisser.DBEntitys.User;
import kernbeisser.Windows.Model;

import java.util.Collection;

public class ManageUserUIModel implements Model {
    Collection<User> getAllUser(){
        return User.getAll(null);
    }
}

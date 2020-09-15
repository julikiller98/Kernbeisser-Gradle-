package kernbeisser.Enums;

import java.util.ArrayList;
import java.util.Collection;
import kernbeisser.DBEntities.*;
import kernbeisser.Security.ActionPermission;
import kernbeisser.Windows.LogIn.LogInModel;

public enum PermissionKey {

  // VALUE
  GO_UNDER_MIN(ActionPermission.class),

  // Window Permissions
  ACTION_OPEN_MANAGE_PRICELISTS(ActionPermission.class),

  // Actions
  ACTION_LOGIN(ActionPermission.class),
  ACTION_TRANSACTION(ActionPermission.class),
  ACTION_TRANSACTION_FROM_OTHER(ActionPermission.class),
  ACTION_TRANSACTION_FROM_KB(ActionPermission.class),
  ACTION_EDIT_USER(ActionPermission.class),
  ACTION_ORDER_CONTAINER(ActionPermission.class),
  ACTION_EDIT_PRICELIST(ActionPermission.class),
  ACTION_DELETE_PRICELIST(ActionPermission.class),
  ACTION_ADD_PRICELIST(ActionPermission.class),

  ARTICLE_KB_NUMBER_READ(Article.class),
  ARTICLE_KB_NUMBER_WRITE(Article.class),
  ARTICLE_SURCHARGE_READ(Article.class),
  ARTICLE_SURCHARGE_WRITE(Article.class),
  ARTICLE_PRICE_LIST_READ(Article.class),
  ARTICLE_PRICE_LIST_WRITE(Article.class),
  ARTICLE_CONTAINER_DEF_READ(Article.class),
  ARTICLE_CONTAINER_DEF_WRITE(Article.class),
  ARTICLE_WEIGH_ABLE_READ(Article.class),
  ARTICLE_WEIGH_ABLE_WRITE(Article.class),
  ARTICLE_LISTED_READ(Article.class),
  ARTICLE_LISTED_WRITE(Article.class),
  ARTICLE_SHOW_IN_SHOP_READ(Article.class),
  ARTICLE_SHOW_IN_SHOP_WRITE(Article.class),
  ARTICLE_DELETED_READ(Article.class),
  ARTICLE_DELETED_WRITE(Article.class),
  ARTICLE_PRINT_AGAIN_READ(Article.class),
  ARTICLE_PRINT_AGAIN_WRITE(Article.class),
  ARTICLE_DELETE_ALLOWED_READ(Article.class),
  ARTICLE_DELETE_ALLOWED_WRITE(Article.class),
  ARTICLE_LOSS_READ(Article.class),
  ARTICLE_LOSS_WRITE(Article.class),
  ARTICLE_INFO_READ(Article.class),
  ARTICLE_INFO_WRITE(Article.class),
  ARTICLE_SOLD_READ(Article.class),
  ARTICLE_SOLD_WRITE(Article.class),
  ARTICLE_OFFERS_READ(Article.class),
  ARTICLE_OFFERS_WRITE(Article.class),
  ARTICLE_DELIVERED_READ(Article.class),
  ARTICLE_DELIVERED_WRITE(Article.class),
  ARTICLE_INTAKE_READ(Article.class),
  ARTICLE_INTAKE_WRITE(Article.class),
  ARTICLE_LAST_DELIVERY_READ(Article.class),
  ARTICLE_LAST_DELIVERY_WRITE(Article.class),
  ARTICLE_DELETED_DATE_READ(Article.class),
  ARTICLE_DELETED_DATE_WRITE(Article.class),
  ARTICLE_COOLING_READ(Article.class),
  ARTICLE_COOLING_WRITE(Article.class),
  ARTICLE_COVERED_INTAKE_READ(Article.class),
  ARTICLE_COVERED_INTAKE_WRITE(Article.class),
  ARTICLE_BASE_ID_READ(ArticleBase.class),
  ARTICLE_BASE_ID_WRITE(ArticleBase.class),
  ARTICLE_BASE_NAME_READ(ArticleBase.class),
  ARTICLE_BASE_NAME_WRITE(ArticleBase.class),
  ARTICLE_BASE_PRODUCER_READ(ArticleBase.class),
  ARTICLE_BASE_PRODUCER_WRITE(ArticleBase.class),
  ARTICLE_BASE_NET_PRICE_READ(ArticleBase.class),
  ARTICLE_BASE_NET_PRICE_WRITE(ArticleBase.class),
  ARTICLE_BASE_METRIC_UNITS_READ(ArticleBase.class),
  ARTICLE_BASE_METRIC_UNITS_WRITE(ArticleBase.class),
  ARTICLE_BASE_SUPPLIER_READ(ArticleBase.class),
  ARTICLE_BASE_SUPPLIER_WRITE(ArticleBase.class),
  ARTICLE_BASE_SUPPLIERS_ITEM_NUMBER_READ(ArticleBase.class),
  ARTICLE_BASE_SUPPLIERS_ITEM_NUMBER_WRITE(ArticleBase.class),
  ARTICLE_BASE_VAT_READ(ArticleBase.class),
  ARTICLE_BASE_VAT_WRITE(ArticleBase.class),
  ARTICLE_BASE_AMOUNT_READ(ArticleBase.class),
  ARTICLE_BASE_AMOUNT_WRITE(ArticleBase.class),
  ARTICLE_BASE_BARCODE_READ(ArticleBase.class),
  ARTICLE_BASE_BARCODE_WRITE(ArticleBase.class),
  ARTICLE_BASE_CONTAINER_SIZE_READ(ArticleBase.class),
  ARTICLE_BASE_CONTAINER_SIZE_WRITE(ArticleBase.class),
  ARTICLE_BASE_SINGLE_DEPOSIT_READ(ArticleBase.class),
  ARTICLE_BASE_SINGLE_DEPOSIT_WRITE(ArticleBase.class),
  ARTICLE_BASE_CONTAINER_DEPOSIT_READ(ArticleBase.class),
  ARTICLE_BASE_CONTAINER_DEPOSIT_WRITE(ArticleBase.class),
  ARTICLE_KORNKRAFT_SYNCHRONISED_READ(ArticleKornkraft.class),
  ARTICLE_KORNKRAFT_SYNCHRONISED_WRITE(ArticleKornkraft.class),
  CONTAINER_ID_READ(Container.class),
  CONTAINER_ID_WRITE(Container.class),
  CONTAINER_ITEM_READ(Container.class),
  CONTAINER_ITEM_WRITE(Container.class),
  CONTAINER_USER_READ(Container.class),
  CONTAINER_USER_WRITE(Container.class),
  CONTAINER_USER_SURCHARGE_READ(Container.class),
  CONTAINER_USER_SURCHARGE_WRITE(Container.class),
  CONTAINER_INFO_READ(Container.class),
  CONTAINER_INFO_WRITE(Container.class),
  CONTAINER_AMOUNT_READ(Container.class),
  CONTAINER_AMOUNT_WRITE(Container.class),
  CONTAINER_NET_PRICE_READ(Container.class),
  CONTAINER_NET_PRICE_WRITE(Container.class),
  CONTAINER_PAYED_READ(Container.class),
  CONTAINER_PAYED_WRITE(Container.class),
  CONTAINER_DELIVERY_READ(Container.class),
  CONTAINER_DELIVERY_WRITE(Container.class),
  CONTAINER_CREATE_DATE_READ(Container.class),
  CONTAINER_CREATE_DATE_WRITE(Container.class),
  INVENTORY_ID_READ(Inventory.class),
  INVENTORY_ID_WRITE(Inventory.class),
  INVENTORY_CREATION_TIME_STAMP_READ(Inventory.class),
  INVENTORY_CREATION_TIME_STAMP_WRITE(Inventory.class),
  INVENTORY_STATE_ID_READ(InventoryState.class),
  INVENTORY_STATE_ID_WRITE(InventoryState.class),
  INVENTORY_STATE_ARTICLE_READ(InventoryState.class),
  INVENTORY_STATE_ARTICLE_WRITE(InventoryState.class),
  INVENTORY_STATE_COUNT_READ(InventoryState.class),
  INVENTORY_STATE_COUNT_WRITE(InventoryState.class),
  JOB_ID_READ(Job.class),
  JOB_ID_WRITE(Job.class),
  JOB_NAME_READ(Job.class),
  JOB_NAME_WRITE(Job.class),
  JOB_DESCRIPTION_READ(Job.class),
  JOB_DESCRIPTION_WRITE(Job.class),
  JOB_CREATE_DATE_READ(Job.class),
  JOB_CREATE_DATE_WRITE(Job.class),
  JOB_UPDATE_DATE_READ(Job.class),
  JOB_UPDATE_DATE_WRITE(Job.class),
  OFFER_ID_READ(Offer.class),
  OFFER_ID_WRITE(Offer.class),
  OFFER_SPECIAL_NET_PRICE_READ(Offer.class),
  OFFER_SPECIAL_NET_PRICE_WRITE(Offer.class),
  OFFER_FROM_DATE_READ(Offer.class),
  OFFER_FROM_DATE_WRITE(Offer.class),
  OFFER_TO_DATE_READ(Offer.class),
  OFFER_TO_DATE_WRITE(Offer.class),
  OFFER_REPEAT_MODE_READ(Offer.class),
  OFFER_REPEAT_MODE_WRITE(Offer.class),
  PERMISSION_ID_READ(Permission.class),
  PERMISSION_ID_WRITE(Permission.class),
  PERMISSION_NAME_READ(Permission.class),
  PERMISSION_NAME_WRITE(Permission.class),
  PERMISSION_KEY_SET_READ(Permission.class),
  PERMISSION_KEY_SET_WRITE(Permission.class),
  PRICE_LIST_ID_READ(PriceList.class),
  PRICE_LIST_ID_WRITE(PriceList.class),
  PRICE_LIST_NAME_READ(PriceList.class),
  PRICE_LIST_NAME_WRITE(PriceList.class),
  PRICE_LIST_SUPER_PRICE_LIST_READ(PriceList.class),
  PRICE_LIST_SUPER_PRICE_LIST_WRITE(PriceList.class),
  PRICE_LIST_UPDATE_DATE_READ(PriceList.class),
  PRICE_LIST_UPDATE_DATE_WRITE(PriceList.class),
  PRICE_LIST_CREATE_DATE_READ(PriceList.class),
  PRICE_LIST_CREATE_DATE_WRITE(PriceList.class),
  PURCHASE_ID_READ(Purchase.class),
  PURCHASE_ID_WRITE(Purchase.class),
  PURCHASE_SESSION_READ(Purchase.class),
  PURCHASE_SESSION_WRITE(Purchase.class),
  PURCHASE_CREATE_DATE_READ(Purchase.class),
  PURCHASE_CREATE_DATE_WRITE(Purchase.class),
  PURCHASE_USER_SURCHARGE_READ(Purchase.class),
  PURCHASE_USER_SURCHARGE_WRITE(Purchase.class),
  SALE_SESSION_ID_READ(SaleSession.class),
  SALE_SESSION_ID_WRITE(SaleSession.class),
  SALE_SESSION_CUSTOMER_READ(SaleSession.class),
  SALE_SESSION_CUSTOMER_WRITE(SaleSession.class),
  SALE_SESSION_SECOND_SELLER_READ(SaleSession.class),
  SALE_SESSION_SECOND_SELLER_WRITE(SaleSession.class),
  SALE_SESSION_SELLER_READ(SaleSession.class),
  SALE_SESSION_SELLER_WRITE(SaleSession.class),
  SETTING_VALUE_ID_READ(SettingValue.class),
  SETTING_VALUE_ID_WRITE(SettingValue.class),
  SETTING_VALUE_SETTING_READ(SettingValue.class),
  SETTING_VALUE_SETTING_WRITE(SettingValue.class),
  SETTING_VALUE_VALUE_READ(SettingValue.class),
  SETTING_VALUE_VALUE_WRITE(SettingValue.class),
  SHELF_ID_READ(Shelf.class),
  SHELF_ID_WRITE(Shelf.class),
  SHELF_LOCATION_READ(Shelf.class),
  SHELF_LOCATION_WRITE(Shelf.class),
  SHELF_ARTICLES_READ(Shelf.class),
  SHELF_ARTICLES_WRITE(Shelf.class),
  SHOPPING_ITEM_ID_READ(ShoppingItem.class),
  SHOPPING_ITEM_ID_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_AMOUNT_READ(ShoppingItem.class),
  SHOPPING_ITEM_AMOUNT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_DISCOUNT_READ(ShoppingItem.class),
  SHOPPING_ITEM_DISCOUNT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_PURCHASE_READ(ShoppingItem.class),
  SHOPPING_ITEM_PURCHASE_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_NAME_READ(ShoppingItem.class),
  SHOPPING_ITEM_NAME_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_KB_NUMBER_READ(ShoppingItem.class),
  SHOPPING_ITEM_KB_NUMBER_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_ITEM_MULTIPLIER_READ(ShoppingItem.class),
  SHOPPING_ITEM_ITEM_MULTIPLIER_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_VAT_READ(ShoppingItem.class),
  SHOPPING_ITEM_VAT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_METRIC_UNITS_READ(ShoppingItem.class),
  SHOPPING_ITEM_METRIC_UNITS_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_UNIT_AMOUNT_READ(ShoppingItem.class),
  SHOPPING_ITEM_UNIT_AMOUNT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_WEIGH_ABLE_READ(ShoppingItem.class),
  SHOPPING_ITEM_WEIGH_ABLE_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_SUPPLIERS_ITEM_NUMBER_READ(ShoppingItem.class),
  SHOPPING_ITEM_SUPPLIERS_ITEM_NUMBER_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_SHORT_NAME_READ(ShoppingItem.class),
  SHOPPING_ITEM_SHORT_NAME_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_SURCHARGE_READ(ShoppingItem.class),
  SHOPPING_ITEM_SURCHARGE_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_CONTAINER_DISCOUNT_READ(ShoppingItem.class),
  SHOPPING_ITEM_CONTAINER_DISCOUNT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_ITEM_RETAIL_PRICE_READ(ShoppingItem.class),
  SHOPPING_ITEM_ITEM_RETAIL_PRICE_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_ITEM_NET_PRICE_READ(ShoppingItem.class),
  SHOPPING_ITEM_ITEM_NET_PRICE_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_SHOPPING_CART_INDEX_READ(ShoppingItem.class),
  SHOPPING_ITEM_SHOPPING_CART_INDEX_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_SINGLE_DEPOSIT_READ(ShoppingItem.class),
  SHOPPING_ITEM_SINGLE_DEPOSIT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_CONTAINER_DEPOSIT_READ(ShoppingItem.class),
  SHOPPING_ITEM_CONTAINER_DEPOSIT_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_CONTAINER_SIZE_READ(ShoppingItem.class),
  SHOPPING_ITEM_CONTAINER_SIZE_WRITE(ShoppingItem.class),
  SHOPPING_ITEM_SUPER_INDEX_READ(ShoppingItem.class),
  SHOPPING_ITEM_SUPER_INDEX_WRITE(ShoppingItem.class),
  SUPPLIER_ID_READ(Supplier.class),
  SUPPLIER_ID_WRITE(Supplier.class),
  SUPPLIER_NAME_READ(Supplier.class),
  SUPPLIER_NAME_WRITE(Supplier.class),
  SUPPLIER_PHONE_NUMBER_READ(Supplier.class),
  SUPPLIER_PHONE_NUMBER_WRITE(Supplier.class),
  SUPPLIER_FAX_READ(Supplier.class),
  SUPPLIER_FAX_WRITE(Supplier.class),
  SUPPLIER_STREET_READ(Supplier.class),
  SUPPLIER_STREET_WRITE(Supplier.class),
  SUPPLIER_LOCATION_READ(Supplier.class),
  SUPPLIER_LOCATION_WRITE(Supplier.class),
  SUPPLIER_EMAIL_READ(Supplier.class),
  SUPPLIER_EMAIL_WRITE(Supplier.class),
  SUPPLIER_SHORT_NAME_READ(Supplier.class),
  SUPPLIER_SHORT_NAME_WRITE(Supplier.class),
  SUPPLIER_SURCHARGE_READ(Supplier.class),
  SUPPLIER_SURCHARGE_WRITE(Supplier.class),
  SUPPLIER_KEEPER_READ(Supplier.class),
  SUPPLIER_KEEPER_WRITE(Supplier.class),
  SUPPLIER_CREATE_DATE_READ(Supplier.class),
  SUPPLIER_CREATE_DATE_WRITE(Supplier.class),
  SUPPLIER_UPDATE_DATE_READ(Supplier.class),
  SUPPLIER_UPDATE_DATE_WRITE(Supplier.class),
  SURCHARGE_TABLE_ID_READ(SurchargeTable.class),
  SURCHARGE_TABLE_ID_WRITE(SurchargeTable.class),
  SURCHARGE_TABLE_SURCHARGE_READ(SurchargeTable.class),
  SURCHARGE_TABLE_SURCHARGE_WRITE(SurchargeTable.class),
  SURCHARGE_TABLE_FROM_READ(SurchargeTable.class),
  SURCHARGE_TABLE_FROM_WRITE(SurchargeTable.class),
  SURCHARGE_TABLE_TO_READ(SurchargeTable.class),
  SURCHARGE_TABLE_TO_WRITE(SurchargeTable.class),
  SURCHARGE_TABLE_NAME_READ(SurchargeTable.class),
  SURCHARGE_TABLE_NAME_WRITE(SurchargeTable.class),
  SURCHARGE_TABLE_SUPPLIER_READ(SurchargeTable.class),
  SURCHARGE_TABLE_SUPPLIER_WRITE(SurchargeTable.class),
  TRANSACTION_ID_READ(Transaction.class),
  TRANSACTION_ID_WRITE(Transaction.class),
  TRANSACTION_VALUE_READ(Transaction.class),
  TRANSACTION_VALUE_WRITE(Transaction.class),
  TRANSACTION_TRANSACTION_TYPE_READ(Transaction.class),
  TRANSACTION_TRANSACTION_TYPE_WRITE(Transaction.class),
  TRANSACTION_FROM_READ(Transaction.class),
  TRANSACTION_FROM_WRITE(Transaction.class),
  TRANSACTION_TO_READ(Transaction.class),
  TRANSACTION_TO_WRITE(Transaction.class),
  TRANSACTION_DATE_READ(Transaction.class),
  TRANSACTION_DATE_WRITE(Transaction.class),
  TRANSACTION_INFO_READ(Transaction.class),
  TRANSACTION_INFO_WRITE(Transaction.class),
  USER_ID_READ(User.class),
  USER_ID_WRITE(User.class),
  USER_PERMISSIONS_READ(User.class),
  USER_PERMISSIONS_WRITE(User.class),
  USER_SHARES_READ(User.class),
  USER_SHARES_WRITE(User.class),
  USER_SOLIDARITY_SURCHARGE_READ(User.class),
  USER_SOLIDARITY_SURCHARGE_WRITE(User.class),
  USER_EXTRA_JOBS_READ(User.class),
  USER_EXTRA_JOBS_WRITE(User.class),
  USER_JOBS_READ(User.class),
  USER_JOBS_WRITE(User.class),
  USER_KERNBEISSER_KEY_READ(User.class),
  USER_KERNBEISSER_KEY_WRITE(User.class),
  USER_EMPLOYEE_READ(User.class),
  USER_EMPLOYEE_WRITE(User.class),
  USER_USERNAME_READ(User.class),
  USER_USERNAME_WRITE(User.class),
  USER_PASSWORD_READ(User.class),
  USER_PASSWORD_WRITE(User.class),
  USER_FIRST_NAME_READ(User.class),
  USER_FIRST_NAME_WRITE(User.class),
  USER_SURNAME_READ(User.class),
  USER_SURNAME_WRITE(User.class),
  USER_PHONE_NUMBER1_READ(User.class),
  USER_PHONE_NUMBER1_WRITE(User.class),
  USER_PHONE_NUMBER2_READ(User.class),
  USER_PHONE_NUMBER2_WRITE(User.class),
  USER_STREET_READ(User.class),
  USER_STREET_WRITE(User.class),
  USER_TOWN_READ(User.class),
  USER_TOWN_WRITE(User.class),
  USER_TOWN_CODE_READ(User.class),
  USER_TOWN_CODE_WRITE(User.class),
  USER_EMAIL_READ(User.class),
  USER_EMAIL_WRITE(User.class),
  USER_CREATE_DATE_READ(User.class),
  USER_CREATE_DATE_WRITE(User.class),
  USER_UPDATE_DATE_READ(User.class),
  USER_UPDATE_DATE_WRITE(User.class),
  USER_USER_GROUP_READ(User.class),
  USER_USER_GROUP_WRITE(User.class),
  USER_UNREADABLE_READ(User.class),
  USER_UNREADABLE_WRITE(User.class),
  USER_LAST_PASSWORD_CHANGE_READ(User.class),
  USER_LAST_PASSWORD_CHANGE_WRITE(User.class),
  USER_FORCE_PASSWORD_CHANGE_READ(User.class),
  USER_FORCE_PASSWORD_CHANGE_WRITE(User.class),
  USER_GROUP_ID_READ(UserGroup.class),
  USER_GROUP_ID_WRITE(UserGroup.class),
  USER_GROUP_VALUE_READ(UserGroup.class),
  USER_GROUP_VALUE_WRITE(UserGroup.class),
  USER_GROUP_INTEREST_THIS_YEAR_READ(UserGroup.class),
  USER_GROUP_INTEREST_THIS_YEAR_WRITE(UserGroup.class),
  USER_SETTING_VALUE_ID_READ(UserSettingValue.class),
  USER_SETTING_VALUE_ID_WRITE(UserSettingValue.class),
  USER_SETTING_VALUE_USER_READ(UserSettingValue.class),
  USER_SETTING_VALUE_USER_WRITE(UserSettingValue.class),
  USER_SETTING_VALUE_USER_SETTING_READ(UserSettingValue.class),
  USER_SETTING_VALUE_USER_SETTING_WRITE(UserSettingValue.class),
  USER_SETTING_VALUE_VALUE_READ(UserSettingValue.class),
  USER_SETTING_VALUE_VALUE_WRITE(UserSettingValue.class);

  private final Class<?> clazz;

  PermissionKey(Class<?> clazz) {
    this.clazz = clazz;
  }

  public PermissionKey getWriteKey() {
    return valueOf(name().replace("READ", "WRITE"));
  }

  public PermissionKey getReadKey() {
    return valueOf(name().replace("WRITE", "READ"));
  }

  public boolean userHas() {
    return LogInModel.getLoggedIn().hasPermission(this);
  }

  public static Collection<PermissionKey> find(Class<?> category) {
    Collection<PermissionKey> out = new ArrayList<>();
    for (PermissionKey value : values()) {
      if (value.clazz == category) {
        out.add(value);
      }
    }
    return out;
  }

  public Class<?> getClazz() {
    return clazz;
  }

  public static Collection<PermissionKey> find(Class<?> category, boolean read, boolean write) {
    Collection<PermissionKey> out = new ArrayList<>();
    for (PermissionKey value : values()) {
      if (value.clazz == category) {
        if ((read && value.name().endsWith("READ")) || (write && value.name().endsWith("WRITE"))) {
          out.add(value);
        }
      }
    }
    return out;
  }
}

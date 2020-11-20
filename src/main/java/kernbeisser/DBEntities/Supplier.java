package kernbeisser.DBEntities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import kernbeisser.DBConnection.DBConnection;
import kernbeisser.Enums.PermissionKey;
import kernbeisser.Enums.Setting;
import kernbeisser.Security.Key;
import kernbeisser.Useful.Tools;
import lombok.Cleanup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
@EqualsAndHashCode(doNotUseGetters = true)
public class Supplier implements Serializable {

  @Id
  @Column(updatable = false, insertable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_ID_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_ID_WRITE)})
  private int id;

  @Column(unique = true)
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_NAME_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_NAME_WRITE)})
  private String name;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_PHONE_NUMBER_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_PHONE_NUMBER_WRITE)})
  private String phoneNumber;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_FAX_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_FAX_WRITE)})
  private String fax;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_STREET_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_STREET_WRITE)})
  private String street;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_STREET_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_STREET_WRITE)})
  private String location;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_EMAIL_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_EMAIL_WRITE)})
  private String email;

  @Column(unique = true)
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_SHORT_NAME_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_SHORT_NAME_WRITE)})
  private String shortName;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_SURCHARGE_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_SURCHARGE_WRITE)})
  private double defaultSurcharge;

  @Column
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_KEEPER_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_KEEPER_WRITE)})
  private String keeper;

  @CreationTimestamp
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_CREATE_DATE_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_CREATE_DATE_WRITE)})
  private Instant createDate;

  @UpdateTimestamp
  @Getter(onMethod_ = {@Key(PermissionKey.SUPPLIER_UPDATE_DATE_READ)})
  @Setter(onMethod_ = {@Key(PermissionKey.SUPPLIER_UPDATE_DATE_WRITE)})
  private Instant updateDate;

  public static Supplier getSupplierByShortName(String shortName) throws NoResultException {
    @Cleanup EntityManager em = DBConnection.getEntityManager();
    return em.createQuery("select s from Supplier s where s.shortName like :sn", Supplier.class)
        .setParameter("sn", shortName)
        .getSingleResult();
  }

  private static Supplier getOrCreateSupplierByShortName(
      String shortName, String defaultName, int defaultSurcharge) {
    try {
      return getSupplierByShortName(shortName);
    } catch (NoResultException e) {
      @Cleanup EntityManager em = DBConnection.getEntityManager();
      EntityTransaction et = em.getTransaction();
      Supplier s = new Supplier();
      s.setName(defaultName);
      s.setShortName(shortName);
      s.setDefaultSurcharge(defaultSurcharge);
      et.begin();
      em.persist(s);
      em.flush();
      et.commit();
      em.close();
      return getSupplierByShortName(shortName);
    }
  }

  public static Supplier getKKSupplier() {
    return getOrCreateSupplierByShortName(
        "KK", "Kornkraft Großhandel", Setting.SURCHARGE_DEFAULT.getIntValue());
  }

  public static Supplier getBakerySupplier() {
    return getOrCreateSupplierByShortName(
        "AWB", "Kennung Backwaren", Setting.SURCHARGE_BAKERY.getIntValue());
  }

  public static Supplier getProduceSupplier() {
    return getOrCreateSupplierByShortName(
        "AWO", "Kennung Obst&Gemüse", Setting.SURCHARGE_PRODUCE.getIntValue());
  }

  public static Supplier getSolidaritySupplier() {
    return getOrCreateSupplierByShortName("SOZ", "Kennung Solidaritätszuschlag", 0);
  }

  public static Supplier getDepositSupplier() {
    return getOrCreateSupplierByShortName("PF", "Kennung Pfand", 0);
  }

  public static List<Supplier> getAll(String condition) {
    return Tools.getAll(Supplier.class, condition);
  }

  @Override
  public String toString() {
    return Tools.decide(() -> getName() + "[" + shortName + "]", "Lieferant[" + id + "]");
  }

  public static Collection<Supplier> defaultSearch(String s, int max) {
    @Cleanup EntityManager em = DBConnection.getEntityManager();
    Collection<Supplier> suppliers =
        em.createQuery(
                "select s from Supplier s where s.name like :n or keeper like :n or s.phoneNumber like :n or s.fax like :n or email like :n",
                Supplier.class)
            .setParameter("n", "%" + s + "%")
            .setMaxResults(max)
            .getResultList();
    em.close();
    return suppliers;
  }
}

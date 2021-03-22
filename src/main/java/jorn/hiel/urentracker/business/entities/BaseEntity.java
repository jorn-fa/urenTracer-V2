 package jorn.hiel.urentracker.business.entities;
 
 import lombok.Setter;
 import lombok.Getter;
 import javax.persistence.GeneratedValue;
 import javax.persistence.Id;
 import javax.persistence.MappedSuperclass;
 import javax.persistence.Version;
 
 
 @MappedSuperclass
 @Getter @Setter
 public class BaseEntity {
 
     @Id
     @GeneratedValue
     private Long id;
 
     @Version
     private Integer version;
 }

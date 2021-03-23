 package jorn.hiel.urentracker.business.entities;
 
 import lombok.Setter;
 import lombok.Getter;

 import javax.persistence.*;


 @MappedSuperclass
 @Getter @Setter
 public class BaseEntity {
 
     @Id
     @GeneratedValue
     @Column(name = "indexNummer")
     private Long id;
 
     @Version
     private Integer version;
 }

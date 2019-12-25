package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Orders")
public class Order {
    @Id
    String pizzaType;
    String clientName;
    String clientAddress;
    Long orderId;
    /*public Order(String pizzaType,String clientName,String clientAddress,Long orderId){
        this.pizzaType=pizzaType;
        this.clientName=clientName;
        this.clientAddress=clientAddress;
        this.orderId=orderId;
    }*/

}

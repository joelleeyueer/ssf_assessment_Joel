package nus.iss.ssf.Models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;

public class CartItems {

    @NotNull(message = "itemname is null")
    @Pattern(regexp="^(apple|orange|bread|cheese|chicken|mineral_water|instant_noodles)$", message="item not found.")
    private String itemname;

    @NotNull(message = "qty is null")
    @Min(value=1, message="Qty min is 1")
    private Integer qty;

    public CartItems(String itemname, Integer qty) {
        this.itemname = itemname;
        this.qty = qty;
    }

    public CartItems() {
    }
    
    
    public String getitemname() {
        return itemname;
    }
    public void setitemname(String itemname) {
        this.itemname = itemname;
    }
    public Integer getqty() {
        return qty;
    }
    public void setqty(Integer qty) {
        this.qty = qty;
    }

    
    
}

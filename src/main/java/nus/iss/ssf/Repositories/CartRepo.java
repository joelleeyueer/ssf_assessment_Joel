package nus.iss.ssf.Repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import nus.iss.ssf.Models.CartItems;

@Repository
public class CartRepo {


    public ArrayList<CartItems> shoppingcart;

    public CartRepo(){        

        if (shoppingcart == null) {
            shoppingcart = new ArrayList<CartItems>();
        }

        shoppingcart.add(new CartItems("apple",2));
        shoppingcart.add(new CartItems("bread",3));
        
    }

    public ArrayList<CartItems> getShoppingcart() {
        return shoppingcart;
    }

    public void setShoppingcart(ArrayList<CartItems> shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

    public ArrayList<CartItems> updateCartValue(ArrayList<CartItems> incomingCart, Integer index, String cartItem, Integer updateQty) {
                Integer newQty = incomingCart.get(index).getqty() + updateQty;
                CartItems newCart = new CartItems(cartItem,newQty);
                incomingCart.set(index,newCart);
        
                return incomingCart;
            }

    public void addToCart(CartItems incomingItem) {
                //check if item exists
                //if yes, add to it
                //if no, add new item
                String incomingItemName = incomingItem.getitemname();
                Integer incomingQty = incomingItem.getqty();
                Boolean isItemExist = false;
                Integer itemIndex = 0;
        
                for (CartItems index:shoppingcart){
                    if (index.getitemname().equalsIgnoreCase(incomingItemName)){
                        isItemExist = true;
                    }
                }
        
                for (int i = 0; i<shoppingcart.size(); i++){
                    if (shoppingcart.get(i).getitemname().equalsIgnoreCase(incomingItemName)){
                        isItemExist = true;
                        itemIndex = i;
                    }
                }
                //item exists, updating the qty
                if (isItemExist){
                    shoppingcart = updateCartValue(shoppingcart, itemIndex,incomingItemName,incomingQty);
                    
                } else { //item does not exist, just add
                    shoppingcart.add(incomingItem);
                    
                }

            }


    @Override
    public String toString() {
        return "CartRepo [shoppingcart=" + shoppingcart + "]";
    }
}

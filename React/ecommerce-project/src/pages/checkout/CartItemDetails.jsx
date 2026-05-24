import { useState } from "react";
import { formatMoney } from "../../utils/money";
import axios from "axios";

import './CartItemDetails.css'

export function CartItemDetails({ cartItem, loadCart }) {
  const [showInputBox, setShowInputBox] = useState(false);
  const [quantity, setQuantity] = useState(cartItem.quantity)
  
  const updateQuantity = (event) => {
    setQuantity(event.target.value);
  };
  
  const updateQuantityAction = async () => {
    if(showInputBox){
      await axios.put(`/api/cart-items/${cartItem.productId}`, {
        quantity: Number(quantity)
      });
      await loadCart();

      setShowInputBox(!showInputBox);
    }else{
      setShowInputBox(!showInputBox);
    }
  };

  const deleteCartItem = async () => {
   await axios.delete(`/api/cart-items/${cartItem.productId}`);
   await loadCart();
  };

  const KeyboardAction = (event) => {
    const keyPressed = event.key;
    
    if(keyPressed === "Enter"){
      updateQuantityAction();

    }else if (keyPressed === "Escape"){
      setQuantity(cartItem.quantity);
      setShowInputBox(false);
    }
  }

  return (
    <>
      <img className="product-image" src={cartItem.product.image} />
      
      <div className="cart-item-details">
        <div className="product-name">{cartItem.product.name}</div>
        <div className="product-price">
          {formatMoney(cartItem.product.priceCents)}
        </div>
        <div className="product-quantity">
          <span>
            Quantity:{" "}
            <input 
              className="quantity-input" 
              type="text" 
              value={quantity}
              onChange={updateQuantity}
              onKeyDown={KeyboardAction}
              style={{ opacity: showInputBox ? 1 : 0 }}
            />
            <span 
              className="quantity-label"
              style={{ opacity: !showInputBox ? 1 : 0 }}
            >{cartItem.quantity}</span>
          </span>

          <span 
            className="update-quantity-link link-primary"
            onClick={updateQuantityAction}
          >Update</span>

          <span 
            className="delete-quantity-link link-primary"
            onClick={deleteCartItem}  
          >Delete</span>
        </div>
      </div>
    </>
  );
}

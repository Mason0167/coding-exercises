import { NavLink, useNavigate, useSearchParams } from 'react-router';
import { useState } from 'react';

import "./Header.css";

import logoWhite from '../assets/images/logo-white.png';
import mobileLogoWhite from '../assets/images/mobile-logo-white.png';
import searchIcon from '../assets/images/icons/search-icon.png';
import cartIcon from '../assets/images/icons/cart-icon.png';

export function Header({ cart }) {
  let totalQuantity = 0;

  cart.forEach((cartItem) => {
    totalQuantity += cartItem.quantity;
  });

  const navigate = useNavigate();

  const [searchParams] = useSearchParams();
  const search = searchParams.get('search');
  
  const [searchText, setSearchText] = useState(search || "");

  const searchBtn = () => {
    navigate(`/?search=${searchText}`);
    setSearchText("");
  };

  const searchInput = (event) => {
    setSearchText(event.target.value);
  };

  return (
    <>
      <div className="header">
        <div className="left-section">
          <NavLink to="/" className="header-link">
            <img className="logo" src={logoWhite} />
            <img className="mobile-logo" src={mobileLogoWhite} />
          </NavLink>
        </div>

        <div className="middle-section">
          <input 
            className="search-bar" 
            type="text" 
            placeholder="Search"  
            value={searchText}  
            onChange={searchInput}
          />

          <button 
            className="search-button"
            onClick={searchBtn}
          >
            <img className="search-icon" src={searchIcon} />
          </button>
        </div>

        <div className="right-section">
          <NavLink className="orders-link header-link" to="/orders">
            <span className="orders-text">Orders</span>
          </NavLink>

          <NavLink className="cart-link header-link" to="/checkout">
            <img className="cart-icon" src={cartIcon} />
            <div className="cart-quantity">{totalQuantity}</div>
            <div className="cart-text">Cart</div>
          </NavLink>
        </div>
      </div>
    </>
  );
}

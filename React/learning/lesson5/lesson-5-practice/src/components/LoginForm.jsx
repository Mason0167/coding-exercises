import { useState } from 'react'

export function LoginForm({ showPassword, setShowPassword }){
    const [inputText, setInputText] = useState('');

    function toggleButton(){

        if(showPassword === true){
            setShowPassword(!showPassword);
        }else{
            setShowPassword(!showPassword);
        }
    }

    function saveInputText(event){
        setInputText(event.target.value);;
    }

    return (
        <>
            <div>
                <input placeholder="Email" className="login-input" />
            </div>

            <div>
                <input 
                    placeholder="Password" 
                    className="login-input"
                    onChange={saveInputText}
                    value={inputText}
                    type={ showPassword ? "text" : "password"} 
                />

                <button 
                    onClick={toggleButton}
                    className="hide-button"
                    
                >Hide
                </button>
            </div>

            <button className="login-button">Login</button>
            <button className="login-button">Sign Up</button>
        </>
    );
}
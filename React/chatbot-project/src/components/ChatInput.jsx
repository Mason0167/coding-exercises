import { useState } from 'react';
import { Chatbot } from 'supersimpledev';
import './ChatInput.css';

import LoadingImage from '../assets/loading-spinner.gif';

export function ChatInput({ chatMessages, setChatMessages }){
  // Store the current data, second one is updater function
  const [inputText, setInputText] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  function saveInputText(event){
    // Gives us the element that we're typing in
    setInputText(event.target.value);
  }

  function keyPress(event){
    {event.key === 'Enter' && sendMessage()}
    {event.key === 'Escape' && setInputText('')}
  }

  async function sendMessage(){

    const newChatMessages = [
      ...chatMessages,
      {
        message: inputText,
        sender: 'user',
        id: crypto.randomUUID()
      }
    ];

    setChatMessages(newChatMessages);

    setIsLoading(true);
    setChatMessages([...newChatMessages,
    {
      message: <img src={LoadingImage} className="loading-spinner" />,
      sender: 'robot',
      id: crypto.randomUUID()
    }]);

    const response = await Chatbot.getResponseAsync(inputText);
    setIsLoading(false);

    setChatMessages([
      ...newChatMessages,
      {
        message: response,
        sender: 'robot',
        id: crypto.randomUUID()
      }
    ]);

    setInputText('');
  }

  return (
    <div className="chat-input-container">
      
      <input 
        placeholder="Send a message to Chatbot" 
        size="30" 
        onChange={saveInputText}
        onKeyDown={keyPress}
        value={inputText}
        className="chat-input"
        disabled={isLoading}
      />

      <button
        onClick={sendMessage}
        className="send-button"
        disabled={isLoading}
      >Send</button>

    </div>
  );
}
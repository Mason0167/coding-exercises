/* Named export */
import { useState } from 'react';
import { Chatbot } from 'supersimpledev';
import { ChatInput } from './components/ChatInput';
import { ChatMessage } from './components/ChatMessage';

/* Default export: Each file focus on 1 thing */ 
import ChatMessages from './components/ChatMessages';

// Vite let us import any types of files
import './App.css'

import RobotProfileImage from './assets/robot.png'
import UserProfileImage from './assets/user.png'

function App(){
  const [chatMessages, setChatMessages] = useState([]);

  /*
  // ShortCut: To extract the values
  const [chatMessages, setChatMessages] = array

  // Current data
  const chatMessages = array[0];

  // Updater function : Function that update the array
  // Always use this to update the data, so React will update the HTML
  const setChatMessages = array[1];

  // We should always create a copy, and then modify the copy
    // This helps React be more efficient
    setChatMessages([
      ...chatMessages,
      {
        message: 'test',
        sender: 'user',
        id: crypto.randomUUID()
      }
    ]);
  }
  */ 

  return (
    <div className="app-container">
      <ChatInput 
        chatMessages={chatMessages}
        setChatMessages={setChatMessages}
      />
      
      <ChatMessages 
        chatMessages={chatMessages}
      />
    </div>
  );
}

export default App

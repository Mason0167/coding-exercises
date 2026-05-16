import { useState, useRef, useEffect } from 'react'
import { Chatbot } from 'supersimpledev'
// Vite let us import any types of files
import './App.css'
import RobotProfileImage from './assets/robot.png'
import UserProfileImage from './assets/user.png'
import LoadingImage from './assets/loading-spinner.gif'


// Customize Hooks function must start with use
function useAutoScroll(dependencies){
  const chatMessagesRef = useRef(null);

  useEffect(() => {
    const containerElem = chatMessagesRef.current;
    if (containerElem) {
      containerElem.scrollTop = containerElem.scrollHeight
    }

    /* Dependency Array: Controls when useEffect runs. 
    [] => Only run once, after the component is created */
  }, [dependencies]);

  return chatMessagesRef
}

function ChatInput({ chatMessages, setChatMessages }){
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

function ChatMessage({ message, sender }){
  /* 
  const message = props.message;
  const sender = props.sender; 
  const { message, sender } = props;

  if(sender === 'robot'){
    return(
      <div>
        <img src="robot.png" width="50"/>
        {message}
      </div>
    );
  }
  */
  
  return (
    <div className={
      sender === 'user' 
        ? 'chat-message-user' 
        : 'chat-message-robot'
    }>

      {sender === 'robot' && (
        <img src={RobotProfileImage} className="chat-message-profile" />
      ) }

      <div className="chat-message-text">
        {message}
      </div>

      {sender === 'user' && (
        <img src={UserProfileImage} className="chat-message-profile" />
      )}
      
    </div>
  );
}

function ChatMessages({ chatMessages }){
  const chatMessagesRef = useAutoScroll(chatMessages);

  return(
    <>
      {chatMessages.length === 0 ? 
        <p className="welcome-message">
          Welcome to the chatbot project! Send a message using the textbox below.
        </p> :

        <div 
          className="chat-message-container"
          ref={chatMessagesRef}
        >
        {chatMessages.map((chatMessage) => {
          return(
            <ChatMessage 
              message = {chatMessage.message}
              sender = {chatMessage.sender}
              key={chatMessage.id}
            />
        );})}
        </div>
      }
    </>
  );
}

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

import { ChatMessage } from "./ChatMessage";
import { useAutoScroll } from '../hooks/useAutoScroll';
import './ChatMessages.css';

function ChatMessages({ chatMessages }){
  const chatMessagesRef = useAutoScroll(chatMessages);

  return(
    <>
      {chatMessages.length === 0 ? 
        <p className="welcome-message">
          Welcome to the chatbot project! Send a message using the textbox below.
        </p> :

        <div 
          className="chat-messages-container"
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

export default ChatMessages;
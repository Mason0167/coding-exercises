import { useRef, useEffect } from 'react';

// Customize Hooks function must start with use
export function useAutoScroll(dependencies){
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
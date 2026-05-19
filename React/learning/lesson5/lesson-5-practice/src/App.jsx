import { useState } from 'react'
import { LoginForm } from './components/LoginForm'
import { TimeSetting } from './components/TimeSetting'
import dayjs from 'dayjs'

import './App.css'

function App(){
  const [showPassword, setShowPassword] = useState('');
  const [time, setTime] = useState(dayjs().format('HH:mm:ss'));

  return (
    <>
      <TimeSetting 
          time={time}
          setTime={setTime}
      />
      <p className="title">Hello, welcome to my website</p>
      <LoginForm 
          showPassword={showPassword}
          setShowPassword={setShowPassword}
      />
    </>
  );
}

export default App

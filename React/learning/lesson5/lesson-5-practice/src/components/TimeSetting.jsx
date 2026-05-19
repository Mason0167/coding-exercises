import { useEffect } from 'react'
import dayjs from 'dayjs'

export function TimeSetting({ time, setTime }){

    useEffect(() => {
        setInterval(() => {
            setTime(dayjs().format('HH:mm:ss'))
            console.log('run code')
        }, 1000)

    // Run once after the component is created
    }, [])

    return(
        <>
            <p>{time}</p>
        </>
    )
}
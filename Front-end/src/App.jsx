import { Suspense, useState } from 'react'
import './App.css'
import { BrowserRouter } from 'react-router-dom'
import PageLoader from './components/PageLoader'
import Routes from './routes/Routes'

function App() {
  return (
    <>
      <BrowserRouter>
        <Suspense fallback={<PageLoader />}>
          <Routes />
        </Suspense>
      </BrowserRouter>
    </>
  )
}

export default App

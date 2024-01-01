import { Suspense, useState } from 'react'
import './App.css'
import { BrowserRouter } from 'react-router-dom'
import PageLoader from './components/PageLoader'
import Routes from './routes/Routes'
import { Provider } from 'react-redux'
import { store } from './states/store'

function App() {
  return (
    <>
      <BrowserRouter>
        <Provider store={store}>
          <Suspense fallback={<PageLoader />}>
            <Routes />
          </Suspense>
        </Provider>
      </BrowserRouter>
    </>
  )
}

export default App

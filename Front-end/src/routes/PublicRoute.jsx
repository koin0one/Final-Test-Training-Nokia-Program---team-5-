import { Navigate } from 'react-router-dom'

const PublicRoute = ({ children }) => {
  return <>{children}</>
  if (window.localStorage.getItem('isLoggedIn')) {
    return <Navigate to='/' replace />
  } else return <>{children}</>
}

export default PublicRoute

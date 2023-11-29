import Dashboard from '@/pages/Dashboard'
import Logout from '@/pages/Logout'
import { useRoutes } from 'react-router-dom'
export default function AppRouter() {
  let element = useRoutes([
    {
      path: '/login',
      element: <Login />
    },
    {
      path: '/logout',
      element: <Logout />
    },
    {
      path: '/',
      element: <Dashboard />
    }
  ])

  return element
}

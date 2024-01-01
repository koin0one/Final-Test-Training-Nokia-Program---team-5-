import Admin from '@/pages/Admin'
import Dashboard from '@/pages/Dashboard'
import Room from '@/pages/Room'
import { useRoutes } from 'react-router-dom'
export default function AppRouter() {
  let element = useRoutes([
    {
      path: '/',
      element: <Dashboard />
    },
    {
      path: '/room',
      element: <Room />
    },
    {
      path: '/admin',
      element: <Admin />
    }
  ])

  return element
}

import React, { Suspense } from 'react'
import AuthRouter from './AuthRouter'
import AppRouter from './AppRouter'
import AppLayout from '@/layout/AppLayout'
import PageLoader from '@/components/PageLoader'

function Routes() {
  //   const { isLoggedIn } = useSelector(selectAuth);
  let isLoggedIn
  if (!isLoggedIn) {
    return (
      <Suspense fallback={<PageLoader />}>
        <AuthRouter />
      </Suspense>
    )
  } else {
    return (
      <Suspense fallback={<PageLoader />}>
        <AppLayout>
          <AppRouter />
        </AppLayout>
      </Suspense>
    )
  }
}

export default Routes

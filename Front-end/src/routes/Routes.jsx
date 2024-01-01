import React, { Suspense } from 'react'
import AuthRouter from './AuthRouter'
import AppRouter from './AppRouter'
import AppLayout from '@/layout/AppLayout'
import PageLoader from '@/components/PageLoader'
import { useSelector } from 'react-redux'
import ContentModal from '@/components/Modal/ContentModal'

function Routes() {
  const { contentDialogProps } = useSelector((state) => state.modalState)
  //   const { isLoggedIn } = useSelector(selectAuth);
  // let isLoggedIn
  // if (!isLoggedIn) {
  //   return (
  //     <Suspense fallback={<PageLoader />}>
  //       <AuthRouter />
  //     </Suspense>
  //   )
  // } else {
  return (
    <Suspense fallback={<PageLoader />}>
      <AppLayout>
        <AppRouter />
      </AppLayout>
      <ContentModal
        isModalOpen={contentDialogProps.isModalOpen}
        handleCancel={contentDialogProps.handleCancel}
        handleOk={contentDialogProps.handleOk}
        modalTitle={contentDialogProps.title}
        children={contentDialogProps.children}
      />
    </Suspense>
  )
}

export default Routes

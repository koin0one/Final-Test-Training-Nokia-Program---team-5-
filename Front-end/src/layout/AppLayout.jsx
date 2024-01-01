import { Layout } from 'antd'
import React from 'react'
import HeaderContent from './HeaderContent'
const { Content, Footer } = Layout
function AppLayout({ children }) {
  return (
    <Layout style={{ minHeight: '100vh' }}>
      <HeaderContent />
      <Content
        style={{
          margin: '40px auto 0px',
          overflow: 'initial',
          width: '100%',
          padding: '0 25px'
        }}
      >
        {children}
      </Content>
      <Footer style={{ textAlign: 'center' }}>Your App ©2023 Created by You</Footer>
    </Layout>
  )
}

export default AppLayout

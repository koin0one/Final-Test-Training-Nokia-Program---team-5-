import { Layout } from 'antd'
import React from 'react'

function AppLayout({ children }) {
  return (
    <Layout style={{ marginLeft: 100 }}>
      {/* <HeaderContent /> */}
      {/* <Content
        style={{
          margin: '40px auto 30px',
          overflow: 'initial',
          width: '100%',
          padding: '0 25px',
          maxWidth: isNavMenuClose ? 1200 : 1100
        }} */}
      {/* > */}
      {children}
      {/* </Content> */}
    </Layout>
  )
}

export default AppLayout

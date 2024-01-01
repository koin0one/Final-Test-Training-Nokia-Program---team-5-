import React from 'react'
import { Space, Layout, Divider } from 'antd'
import { Typography } from 'antd'
import BackgroundLogin from '../../assets/react.svg'
const { Content } = Layout

export default function SideContent() {
  return (
    <Content
      style={{
        width: '100%',
        margin: '0 auto',
        height: '100vh'
      }}
      className='sideContent'
    >
      <img src={BackgroundLogin} style={{ objectFit: 'cover', height: '100vh' }} />
    </Content>
  )
}

import { Spin } from 'antd'
import React from 'react'

function PageLoader() {
  return (
    <div className='centerAbsolute'>
      <Spin size='large' />
    </div>
  )
}

export default PageLoader

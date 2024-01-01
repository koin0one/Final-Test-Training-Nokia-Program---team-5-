import React, { useState } from 'react'
import { Modal, Button } from 'antd'
import './ContentModal.css'
const ContentModal = ({ isModalOpen, handleCancel, handleOk, modalTitle, children }) => {
  return (
    <Modal
      title={modalTitle}
      open={isModalOpen}
      onCancel={handleCancel}
      onOk={handleOk}
      footer={[
        <Button key='cancel' onClick={handleCancel}>
          Cancel
        </Button>,
        <Button key='ok' type='primary' onClick={handleOk}>
          OK
        </Button>
      ]}
    >
      {children}
    </Modal>
  )
}

export default ContentModal

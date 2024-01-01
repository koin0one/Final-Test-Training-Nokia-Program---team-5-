import React from 'react'
import { Form, Input, Checkbox, Button } from 'antd'
import { UserOutlined, LockOutlined } from '@ant-design/icons'
import { Link } from 'react-router-dom'
import './LoginForm.css'
import RegisterForm from './RegisterForm'
import { useDispatch } from 'react-redux'
import { resetModalState, setContentDialogProps } from '@/states/modalState'

export default function LoginForm() {
  const dispatch = useDispatch()

  const handleOpenRegister = () => {
    dispatch(resetModalState())
    dispatch(
      setContentDialogProps({
        isModalOpen: true,
        title: 'Sign up',
        handleClick: () => {},
        handleCancel: () => dispatch(resetModalState()),
        children: <RegisterForm />
      })
    )
  }
  const handleSignIn = (value) => {
    console.log(value)
  }

  return (
    <>
      <Form
        layout='vertical'
        name='normal_login'
        className='login-form'
        initialValues={{
          remember: true
        }}
        onFinish={handleSignIn}
      >
        <Form.Item
          label='Email'
          name='email'
          rules={[
            {
              required: true,
              message: 'Please input your email'
            },
            {
              type: 'email'
            }
          ]}
        >
          <Input
            prefix={<UserOutlined className='site-form-item-icon' />}
            placeholder='admin@demo.com'
            type='email'
            autoComplete='email'
            size='large'
          />
        </Form.Item>
        <Form.Item
          label='Password'
          name='password'
          rules={[
            {
              required: true,
              message: 'Please input your password'
            }
          ]}
        >
          <Input.Password
            prefix={<LockOutlined className='site-form-item-icon' />}
            placeholder='admin123'
            size='large'
          />
        </Form.Item>

        <div style={{ display: 'flex', flexDirection: 'row' }}>
          <Form.Item name='remember' valuePropName='checked' noStyle>
            Not have an account yet?
          </Form.Item>
          <div
            onClick={handleOpenRegister}
            style={{ color: '#007bff', textDecoration: 'underline', cursor: 'pointer' }}
          >
            Register here
          </div>
        </div>
      </Form>
    </>
  )
}

import React from 'react'
import { Link } from 'react-router-dom'
import { Layout, Menu, Button } from 'antd'
import { useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux'
import { resetModalState, setContentDialogProps } from '@/states/modalState'
import LoginForm from '@/components/Form/LoginForm'
import RegisterForm from '@/components/Form/RegisterForm'

const { Header } = Layout

export default function HeaderContent() {
  const navigate = useNavigate()
  const dispatch = useDispatch()

  const handleSignIn = () => {
    dispatch(
      setContentDialogProps({
        isModalOpen: true,
        title: 'Login',
        handleClick: () => {},
        handleCancel: () => dispatch(resetModalState()),
        children: <LoginForm />
      })
    )
  }

  const handleSignUp = () => {
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

  const items = [
    {
      label: <Link to={'/'}>About</Link>,
      key: 'about'
    },
    {
      label: <Link to={'/room'}>Room</Link>,
      key: 'room'
    },
    {
      label: <Link to={'/room'}>Admin</Link>,
      key: 'admin'
    }
  ]

  return (
    <Header
      style={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        background: '#001529',
        padding: '0 20px',
        boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)'
      }}
    >
      <Menu
        theme='dark'
        mode='horizontal'
        defaultSelectedKeys={['about']}
        items={items}
        style={{
          flex: 1,
          minWidth: 0
        }}
      ></Menu>
      <div>
        <Button type='text' style={{ color: '#fff', marginRight: '20px' }} onClick={handleSignIn}>
          Sign In
        </Button>
        <Button type='primary' onClick={handleSignUp}>
          Sign Up
        </Button>
      </div>
    </Header>
  )
}

import { Form, Button, Layout, Col, Divider, Typography } from 'antd'
import ReactLogo from '../assets/react.svg'
import AuthLayout from '@/layout/AuthLayout'
import LoginForm from '@/components/Form/LoginForm'
import SideContent from '@/components/SideContent'

const { Content } = Layout
const { Title } = Typography

const LoginPage = () => {
  // const { isLoading, isSuccess } = useSelector(selectAuth);
  // const navigate = useNavigate();
  // const isMobile = useIsMobile();

  // const dispatch = useDispatch();
  const onFinish = (values) => {
    console.log(values)
    // dispatch(login({ loginData: values }));
  }

  // useEffect(() => {
  //   if (isSuccess) navigate('/');
  // }, [isSuccess]);
  return (
    <>
      <AuthLayout sideContent={<SideContent />}>
        <Content
          style={{
            padding: '140px 30px 30px',
            maxWidth: '440px',
            margin: '0 auto'
          }}
        >
          <Col xs={{ span: 24 }} sm={{ span: 24 }} md={{ span: 0 }} span={0}>
            <img
              src={ReactLogo}
              alt='Logo'
              style={{
                margin: '-70px auto 40px',
                display: 'block'
              }}
            />
          </Col>
          <Title level={1}>Sign in</Title>

          <Divider />
          <div className='site-layout-content'>
            <Form
              layout='vertical'
              name='normal_login'
              className='login-form'
              initialValues={{
                remember: true
              }}
              onFinish={onFinish}
            >
              <LoginForm />
              <Form.Item>
                <Button type='primary' htmlType='submit' className='login-form-button' size='large'>
                  Log in
                </Button>
              </Form.Item>
            </Form>
          </div>
        </Content>
      </AuthLayout>
    </>
  )
}

export default LoginPage

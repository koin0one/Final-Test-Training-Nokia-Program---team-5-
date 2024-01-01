// AboutPage.js
import React, { useEffect } from 'react'
import { Typography, Card, Button, Row, Col, Carousel, Space, Divider } from 'antd'
import './Dashboard.css'
const { Title, Paragraph } = Typography
import { EnvironmentOutlined } from '@ant-design/icons'
import hotelImage from '../assets/background-image.jpg'

const Dashboard = () => {
  const popularHotels = [
    { name: 'Luxury Hotel A', location: 'City A', img: hotelImage },
    { name: 'Oceanfront Resort B', location: 'Beach B', img: hotelImage },
    { name: 'City Center Hotel C', location: 'Downtown C', img: hotelImage },
    { name: 'Mountain Lodge D', location: 'Mountain Town D', img: hotelImage },
    { name: 'Riverside Inn E', location: 'Riverfront E', img: hotelImage },
    { name: 'Grand Plaza F', location: 'City F', img: hotelImage },
    { name: 'Seaside Retreat G', location: 'Seaside G', img: hotelImage },
    { name: 'Urban Oasis H', location: 'City H', img: hotelImage },
    { name: 'Lakeview Resort I', location: 'Lake Town I' },
    { name: 'Skyline Hotel J', location: 'City J' },
    { name: 'Tranquil Lodge K', location: 'Countryside K' },
    { name: 'Harborfront Hotel L', location: 'Harbor L' },
    { name: 'Alpine Chalet M', location: 'Mountain Village M' },
    { name: 'Beachside Inn N', location: 'Beach N' },
    { name: 'Downtown Suites O', location: 'Downtown O' },
    { name: 'Serenity Resort P', location: 'Resort P' },
    { name: 'Historic Mansion Q', location: 'City Q' },
    { name: 'Valley View Hotel R', location: 'Valley R' },
    { name: 'Golden Sands S', location: 'Beach S' }
  ]

  const carouselSettings = {
    autoplay: true,
    infinite: true,
    slidesToShow: 5,
    slidesToScroll: 4
  }

  return (
    <div className='about-container'>
      <div className='hero-section'>
        <Title level={1} style={{ color: '#fff' }}>
          Discover Your Perfect Stay
        </Title>
        <Paragraph style={{ color: '#fff' }}>
          Explore our collection of top-rated hotels and find the perfect accommodation for your next journey.
        </Paragraph>
        <Button type='primary' size='large'>
          Explore Rooms
        </Button>
      </div>
      <div className='popular-hotels-section'>
        <Title level={2}>Popular Hotels</Title>
        <Carousel {...carouselSettings}>
          {popularHotels.map((hotel, index) => (
            <Row key={index} gutter={16}>
              <Col>
                <Card
                  style={{ padding: '24px' }}
                  cover={<img src={hotel.img} style={{ objectFit: 'cover', height: '200px' }} alt={hotel.name} />}
                >
                  <Title level={4}>{hotel.name}</Title>
                  <Divider />
                  <Space>
                    <EnvironmentOutlined />
                    <div>{hotel.location}</div>
                  </Space>
                </Card>
              </Col>
            </Row>
          ))}
        </Carousel>
      </div>
    </div>
  )
}

export default Dashboard

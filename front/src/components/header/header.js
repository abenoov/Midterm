import React from 'react';

import {
    BrowserRouter as Router,
    Link,
} from "react-router-dom";

import {
    Row, Col
} from 'antd';
import {Button, Input, Menu} from 'antd';

import {Avatar, Badge} from 'antd';
import {UserOutlined} from '@ant-design/icons';

import './header.css'

import {FaHome} from "react-icons/fa";
import {FaChalkboard} from "react-icons/fa";
import {FaSignOutAlt} from "react-icons/fa";
import {FaPlusCircle} from "react-icons/fa";



import SignUpModal from '../auth/signupModal'
import LogInModal from '../auth/loginModal'

import {logoutUser} from "../../store/actions/authAction";

import {connect} from 'react-redux'
import NewBillModal from "../auth/newModal";


class Header extends React.Component {
    constructor() {
        super()
        this.state = {
            openLogIn: false,
            openSignUp: false,
            openNew: false,
        }
    }


    state = {
        size: 'large',
    };
    handleExit = values => {
        this.props.logoutUser()
    };


    openLogIn = () => {
        this.setState({openLogIn: true})
    }

    openNew = () => {
        this.setState({openNew: true})
    }

    openSignUp = () => {
        this.setState({openSignUp: true})
    }

    closeSignUp = () => {
        this.setState({openSignUp: false})
    }

    closeNew = () => {
        this.setState({openNew: false})
    }

    closeLogIn = () => {
        this.setState({openLogIn: false})
    }

    componentWillReceiveProps(nextProps, nextContext) {
        console.log("Hello", nextProps)
        if (nextProps.auth.isAuthenticated) {
            this.setState({openLogIn: false, openSignUp: false})
        }
    }


    render() {
        const {Search} = Input;
        const {size} = this.state;

        const isAuth = this.props.auth.isAuthenticated;

        let nav = (
            <Row>
                <Col className={"header__left"} span={18} style={{display: 'flex', justifyContent: 'flex-start'}}>
                    {/*<img className="logo" src={logo} alt=""/>*/}
                    <Link to="/myfeed">
                        <Button type="primary" size={size}>
                            {/*<img className="logo" src={require('/one.jpeg')}alt=""/>*/}
                            <FaHome/>
                        </Button>
                    </Link>
                </Col>
                <Col className={"header__right"} span={6} style={{display: 'flex', justifyContent: 'flex-end'}}>
                    <Button type="primary" size={size} onClick={this.openNew}>
                        <FaPlusCircle/>
                    </Button>
                    <Link to="/">
                        <Button type="primary" size={size} onClick={this.handleExit}>
                            <FaSignOutAlt/>
                        </Button>
                    </Link>
                    <Link to="/">
                        <div>
                            {/*<span className="avatar-item">*/}
                            {/*  <Badge count={1}>*/}
                            {/*    <Avatar shape="square" icon={<UserOutlined/>}/>*/}
                            {/*  </Badge>*/}
                            {/*</span>*/}
                            <span>
                              <Badge dot>
                                <Avatar shape="square" icon={<UserOutlined/>}/>
                              </Badge>
                            </span>
                        </div>
                    </Link>
                </Col>
            </Row>
        )

        if (!isAuth)
            nav = (
                <Row>
                    <Col className={"header__left"} span={18} style={{display: 'flex', justifyContent: 'flex-start'}}>
                    </Col>
                    <Col>
                        <Menu mode="horizontal">
                            <Menu.Item key={1} onClick={this.openSignUp}>Sign Up</Menu.Item>
                            <Menu.Item key={2} onClick={this.openLogIn}>Log In</Menu.Item>
                        </Menu>
                    </Col>
                </Row>
            )

        return <header className="header">

            {nav}
            <SignUpModal openSignUp={this.state.openSignUp} onClose={this.closeSignUp}/>
            <LogInModal openLogIn={this.state.openLogIn} onClose={this.closeLogIn}/>
            <NewBillModal openNew={this.state.openNew} onClose={this.closeNew}/>

        </header>
    }
}

const mapStateToProps = (state) => ({
    auth: state.auth
})


export default connect(mapStateToProps, {logoutUser})(Header)
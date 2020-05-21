import React from 'react';
import {connect} from 'react-redux'

import {Link, withRouter} from 'react-router-dom'

import {Switch, Card} from 'antd';
import {addBill, getBills} from "../../store/actions/billAction";

import {Row, Col} from "antd";

import './mian.css'

import {message, Modal, Button} from 'antd';
import {BackTop} from 'antd';

const {Meta} = Card;

class PetMain extends React.Component {
    constructor() {
        super()
        this.state = {
            bills: {},
            authority:{}
        }

    }

    showModal = (bill) => {
        // console.log(pet)
        this.setState({
            modalVisible: true,
            bills: bill
        });
    };


    handleOk = bill => e => {
        this.props.addBill(bill)
        message.success('Successfully adopted a pet');
        this.setState({
            modalVisible: false,
        });
    };

    handleCancel = e => {
        console.log(e);
        this.setState({
            modalVisible: false,
        });
    };

    onChange = checked => {
        this.setState({loading: !checked});
    };

    componentDidMount() {
        this.props.getBills();
        this.setState({authority: localStorage.getItem('authority')});
    }

    componentWillReceiveProps(nextProps, nextContext) {
        console.log("Hello", nextProps)
        if (nextProps.auth.isAuthenticated) {
            this.setState({openLogIn: false, openSignUp: false})
        }
        if (nextProps.bills.length > 0) {
            this.setState({bills: nextProps.bills})
        }

    }


    render() {
        const {loading} = this.state;

        const isAuth = this.props.auth.isAuthenticated;
        const bills = this.props.bills.bills;
        console.log("ahh"+bills)
        let nav = ""
        if (isAuth) {
            nav = bills.map(bill => (
                <Col span={6} key={bill.id} onClick={() => this.showModal(bill)}>
                    <Card loading={loading}
                          hoverable
                          style={{width: 240}}
                    >
                        <Meta title={bill.kwh} description={bill.price}/>
                    </Card>
                </Col>
            ))
        }

        return <div className="main">
            <Row gutter={16} justify="start">
                {/*<Switch checked={!loading} onChange={this.onChange} />*/}
                {nav}
                <Modal
                    title="Data"
                    visible={this.state.modalVisible}
                    // onOk={}
                    onCancel={this.handleCancel}
                    footer={[
                        <Button key="back" onClick={this.handleCancel}>
                            Cancle
                        </Button>,
                        <Button key="submit" type="primary" loading={loading} onClick={this.handleOk(
                            {
                                user_id:  27,
                                pet_id: "this.state.pet.id"
                            }
                        )}>
                            Adopt
                        </Button>,
                    ]}
                >
                    <Col justify={"center"}>
                        <h1>Price: {this.state.bills.price} KZT</h1>
                        <h3>Kwh: {this.state.bills.kwh}</h3>
                    </Col>
                </Modal>
                <BackTop/>
            </Row>

        </div>
    }
}

const mapStateToProps = (state) => ({
    auth: state.auth,
    bills: state.bills
})


export default connect(mapStateToProps, {getBills, addBill})(withRouter(PetMain))

import React, { Component } from 'react'
import { Modal, Button, Form, Input } from 'antd'
import {loginUser, signupUser} from '../../store/actions/authAction'
import {addBill} from "../../store/actions/billAction";
import {connect} from 'react-redux'

class NewBillModal extends Component {

    handleSubmit = values => {
        console.log(values)
        this.props.addBill({
            kwh:  values.kwh,
            price: values.price
        })
    };

    render() {
        return (
            <Modal
                visible={this.props.openNew}
                title="Add a bill"
                onCancel={this.props.onClose}
                footer={null}
            >
                <Form onFinish={this.handleSubmit} className="login-form">
                    <Form.Item  name="kwh" rules={[{ required: true }]}>
                        <Input
                            // prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                            placeholder="kwh"
                        />
                    </Form.Item>
                    <Form.Item  name="price" rules={[{ required: true }]}>
                        <Input
                            // prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                            placeholder="price"
                        />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit" className="login-form-button">
                            Add
                        </Button>
                        <br/>
                    </Form.Item>
                </Form>
            </Modal>
        )
    }
}
export default connect(null, {addBill})(NewBillModal)
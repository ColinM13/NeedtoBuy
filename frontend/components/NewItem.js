import React from 'react';

export default class FirstComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            itemName: "",
            quantity: 0,
        };

        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleQuantityChange = this.handleQuantityChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleNameChange(event) {
        this.setState({itemName: event.target.value});
    }

    handleQuantityChange(event) {
        this.setState({quantity: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        
        const requestParams = {
            method: 'POST',
            headers: {'content-type': 'application/json'},
            body: JSON.stringify({
                "name": this.state.itemName,
                "quantity": this.state.quantity
            })
        }

        fetch('http://192.168.1.231:8080/api/v1/items', requestParams)
            .then(response => console.log(response.status));
            
        this.setState({
            itemName: '',
            quantity: 0
        })

        this.props.submitted();
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    Item Name
                    <input type="text" id="itemName" value={this.state.itemName} onChange={this.handleNameChange} />
                </label>
                <label>
                    quantity
                    <input type="text" id="itemQuantity" value={this.state.quantity} onChange={this.handleQuantityChange} />
                </label>
                <input type="submit" onSubmit={this.handleSubmit} />
            </form>
        )
    }
}
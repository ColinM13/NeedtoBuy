import React from 'react';

export default class ItemList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            isCheckedOff: false,
        };
    }

    clicked(key) {
        //alert("list item clicked: " + key);
        console.log("Here! " + this.state.isCheckedOff);
        this.setState({isCheckedOff: !this.state.isCheckedOff});
    }

    render() {
        const listItems = this.props.listItems;
        

        return (
            <li class={this.state.isCheckedOff ? "checked-off-item" : "list-item"} key={this.props.item.uuid.toString()} onClick={this.clicked.bind(this, this.props.item.uuid)}>
                <span class={this.state.isCheckedOff ? "checked-off-left" : "left"}>{this.props.item.name}</span>
                <span class={this.state.isCheckedOff ? "checked-off-right" : "right"}>{this.props.item.quantity}</span>
            </li>
        );
    };

}
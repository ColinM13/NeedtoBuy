import React from 'react';
import NewItem from './NewItem.js';import ItemList from './ItemList.js';

export default class FirstComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            listItems: []
        };

        this.getListOfItems = this.getListOfItems.bind(this);
    }

    getListOfItems() {
        fetch('http://192.168.1.231:8080/api/v1/items', {credentials: 'same-origin'})
            .then(res => res.json())
            .then(
                (data) => {
                    console.log(data);
                    this.setState({
                        isLoaded: true,
                        listItems: data
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            );
    }

    componentDidMount() {
        this.getListOfItems();
    }

    render() {
        const { error, isLoaded, listItems } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
          } else if (!isLoaded) {
            return <div>Loading...</div>;
          } else {
            return (
                <>
                    <NewItem submitted={this.getListOfItems} />
                    <ItemList listItems={this.state.listItems} />
                </>            
            );
          }
    }
}
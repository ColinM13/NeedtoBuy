import React from 'react';
import ListRow from './ListRow.js';

export default class ItemList extends React.Component {

    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         isCheckedOff: false,
    //     };
    // }

    // clicked(key) {
    //     //alert("list item clicked: " + key);
    //     console.log("Here! " + this.state.isCheckedOff);
    //     this.setState({isCheckedOff: !this.state.isCheckedOff});
    // }

    render() {
        const listItems = this.props.listItems;

        return (
            <ul class="list-of-items">
                {listItems.map(item => (
                    <ListRow item={item} />
                ))}
            </ul>
        );
    };

}
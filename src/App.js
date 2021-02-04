import './App.css';
import FirstComponent from './components/FirstComponent.js';
import NewItem from './components/NewItem.js';

function App() {

  let submittedNewItem = false;

  return (
    <div className="App">
      <div class="list-of-items-div">
        <FirstComponent />
      </div>
    </div>
  );
}

export default App;

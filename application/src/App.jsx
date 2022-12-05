import { useState, useEffect } from "react";
import "./App.css";
import { useSearchParams } from "react-router-dom";
import axios from "axios";
import Table from "./Table";

function App() {
  let [searchParams, setSearchParams] = useSearchParams();
  const [pageData, setPageData] = useState([]);

  // Set default search params
  useEffect(() => {
    if (searchParams.get("page") == null) {
      setSearchParams({
        page: "1",
      });
    }
  }, []);

  // Query backend
  useEffect(() => {
    axios
      .get("/api", {
        params: searchParams,
      })
      .then((response) => {
        setPageData(response.data);
      });
  }, [searchParams]);

  function decrementPage() {
    // Don't go below page 1
    if (searchParams.get("page") == "1") {
      return;
    }
    // Decrement page
    else {
      setSearchParams({
        page: String(parseInt(searchParams.get("page")) - 1),
      });
    }
  }

  function incrementPage() {
    // Increment page
    setSearchParams({
      page: String(parseInt(searchParams.get("page")) + 1),
    });
  }

  return (
    <div className="App bg-slate-200 p-10">
      <h1 className="text-4xl font-bold">Title</h1>
      <div className="">
        <button onClick={() => decrementPage()}>Page Back</button>
        <p>{searchParams.get("page")}</p>
        <button onClick={() => incrementPage()}>Page Forward</button>
      </div>
      <Table pageData={pageData} />
    </div>
  );
}

export default App;

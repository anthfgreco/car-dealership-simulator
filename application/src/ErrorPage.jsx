import { useRouteError, Link } from "react-router-dom";

function ErrorPage() {
  const error = useRouteError();
  return (
    <div className="flex h-screen	w-screen flex-col items-center justify-center">
      <h1>Oops, an unexpected error has occurred!</h1>
      <p>{error.status + " " + error.statusText}</p>
      <br />
      <p>
        Go back home:{" "}
        <Link
          to="/"
          className="font-semibold text-violet-500 hover:text-violet-900"
        >
          Home
        </Link>
      </p>
    </div>
  );
}

export default ErrorPage;

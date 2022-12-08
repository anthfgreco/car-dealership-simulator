function ContactSellerForm() {
  function testFunction(x) {
    console.log(x);
  }

  return (
    <form className="h-[530px] w-[360px] bg-[#3e3e3e]">
      <div className="form-nav-bar flex flex-row text-[#ffffff]">
        <div
          className="flex w-1/3 items-center justify-center text-center"
          onClick={() => testFunction(0)}
        >
          General Inquiry
        </div>
        <div
          className="flex w-1/3 items-center justify-center text-center"
          onClick={() => testFunction(1)}
        >
          <span>Book An Appointment</span>
        </div>
        <div
          className="flex w-1/3 items-center justify-center text-center"
          onClick={() => testFunction(2)}
        >
          <span>Make An Offer</span>
        </div>
      </div>

      <hr className="mb-5"></hr>

      <div className="relative z-0 mb-6 flex h-16 w-full bg-slate-100">
        <input
          type="text"
          name="floating_name"
          id="floating_name"
          className="peer block w-full appearance-none border-0 border-b-2 border-gray-300 bg-transparent py-2.5 px-0 text-sm text-gray-900 focus:border-blue-600 focus:outline-none focus:ring-0 dark:border-gray-600 dark:text-white dark:focus:border-blue-500"
          placeholder=" "
          required
        />
        <label
          htmlFor="floating_name"
          className="absolute top-3 -z-10 origin-[0] -translate-y-6 scale-75 transform text-sm text-gray-500 duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:left-0 peer-focus:-translate-y-6 peer-focus:scale-75 peer-focus:font-medium peer-focus:text-blue-600 dark:text-gray-400 peer-focus:dark:text-blue-500"
        >
          Name
        </label>
      </div>
      <div className="relative z-0 mb-6 w-full">
        <input
          type="email"
          name="floating_email"
          id="floating_email"
          className="peer block w-full appearance-none border-0 border-b-2 border-gray-300 bg-transparent py-2.5 px-0 text-sm text-gray-900 focus:border-blue-600 focus:outline-none focus:ring-0 dark:border-gray-600 dark:text-white dark:focus:border-blue-500"
          placeholder=" "
          required
        />
        <label
          htmlFor="floating_email"
          className="absolute top-3 -z-10 origin-[0] -translate-y-6 scale-75 transform text-sm text-gray-500 duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:left-0 peer-focus:-translate-y-6 peer-focus:scale-75 peer-focus:font-medium peer-focus:text-blue-600 dark:text-gray-400 peer-focus:dark:text-blue-500"
        >
          Email address
        </label>
      </div>
      <div className="relative z-0 mb-6 w-full">
        <input
          type="text"
          name="floating_phone_number"
          id="floating_phone_number"
          className="peer block w-full appearance-none border-0 border-b-2 border-gray-300 bg-transparent py-2.5 px-0 text-sm text-gray-900 focus:border-blue-600 focus:outline-none focus:ring-0 dark:border-gray-600 dark:text-white dark:focus:border-blue-500"
          placeholder=" "
          required
        />
        <label
          htmlFor="floating_email"
          className="absolute top-3 -z-10 origin-[0] -translate-y-6 scale-75 transform text-sm text-gray-500 duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:left-0 peer-focus:-translate-y-6 peer-focus:scale-75 peer-focus:font-medium peer-focus:text-blue-600 dark:text-gray-400 peer-focus:dark:text-blue-500"
        >
          Email address
        </label>
      </div>
    </form>
  );
}

export default ContactSellerForm;

import { Address } from "./address";

export interface User {
  jmbg: string;
  name: string;
  surname: string;
  email: string;
  gender: string;
  address: Address;
  city: string;
  state: string;
  password: string;
  phoneNumber: string;
  points: string;
  user_catagory: string;

}

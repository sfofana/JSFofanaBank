import { Account } from "./account";

export interface User {
    _id?: string;
    id?: number;
    email: string;
    password: string;
    firstname?: string;
    lastname?: string;
    accounts?: Account[];
}

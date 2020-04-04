import * as React from "react";

import { User } from "../interfaces";
import { userInfo } from "os";

type ListDetailProps = {
  item: User;
};

const ListDetail: React.FunctionComponent<ListDetailProps> = ({
  item: user
}) => (
  <div>
    <h1>Detail for {user.name}</h1>
    <p>ID: {user.id}</p>
  </div>
);

export default ListDetail;

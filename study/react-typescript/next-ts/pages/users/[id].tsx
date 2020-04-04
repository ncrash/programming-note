import React from "react";
import { GetStaticProps, GetStaticPaths } from "next";

import { User } from "../../interfaces";
import { sampleUserData } from "../../utils/sample-data";
import Layout from "../../components/Layout";
import ListDetail from "../../components/ListDetail";

type Props = {
  item?: User;
  errors?: string;
};

export default class StaticPropsDetail extends React.Component<Props> {
  render() {
    const { item, errors } = this.props;

    if (errors) {
      return (
        <Layout title={`Error | Next.js + TypeScript Example`}>
          <p>
            <span style={{ color: "red" }}>Error:</span> {errors}
          </p>
        </Layout>
      );
    }

    return (
      <Layout
        title={`${
          item ? item.name : "User Detail"
        } | Next.js + TypeScript Example`}
      >
        {item && <ListDetail item={item} />}
      </Layout>
    );
  }
}

export const getStaticPaths: GetStaticPaths = async () => {
  const paths = sampleUserData.map(user => ({
    params: { id: user.id.toString() }
  }));

  return { paths, fallback: false };
};

export const getStaticProps: GetStaticProps = async ({ params }) => {
  try {
    const id = params?.id;
    const item = sampleUserData.find(data => data.id === Number(id));

    return { props: { item } };
  } catch (err) {
    return { props: { erros: err.message } };
  }
};

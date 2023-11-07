// import CredentialsProvider from 'next-auth/providers/credentials'
// import { TokenResponse } from '@/types/auth/TokenType'
// import { NuxtAuthHandler } from '#auth'
// import axios from '@/utils/axios'
//
// export default NuxtAuthHandler({
//   // secret needed to run nuxt-auth in production mode (used to encrypt data)
//   secret: process.env.NUXT_SECRET,
//   pages: {
//     // Change the default behavior to use `/login` as the path for the sign-in page
//     signIn: '/auth/login',
//   },
//   providers: [
//     // @ts-ignore Import is exported on .default during SSR, so we need to call it this way. May be fixed via Vite at some point
//     CredentialsProvider.default({
//       // The name to display on the sign in form (e.g. 'Sign in with...')
//       name: 'Credentials',
//       // The credentials is used to generate a suitable form on the sign in page.
//       // You can specify whatever fields you are expecting to be submitted.
//       // e.g. domain, username, password, 2FA token, etc.
//       // You can pass any HTML attribute to the <input> tag through the object.
//       credentials: {
//         username: { label: 'Email', type: 'text', placeholder: '(hint: jsmith)' },
//         password: { label: 'Password', type: 'password', placeholder: '(hint: hunter2)' },
//       },
//       async authorize(credentials: any) {
//         try {
//           const runtimeConfig = useRuntimeConfig()
//           const { data: res } = await axios.post<TokenResponse>(
//             runtimeConfig.public.apiBase + '/auth/login',
//             credentials
//           )
//           // If no error and we have user data, return it
//           if (res.success && res.data?.user) {
//             return {
//               ...res.data?.user,
//               access_token: res.data?.token,
//             }
//           }
//
//           return null
//         } catch (e) {
//           throw createError({
//             statusCode: 403,
//             statusMessage: 'Credentials not working',
//           })
//         }
//       },
//     }),
//   ],
//   callbacks: {
//     jwt: ({ token, user }) => {
//       const isSignIn = !!user
//       if (isSignIn) {
//         token.jwt = user ? (user as any).access_token || '' : ''
//         token.id = user ? user.id || '' : ''
//       }
//       return Promise.resolve(token)
//     },
//     session: ({ session, token }) => {
//       ;(session as any).jwt = token.jwt
//       ;(session as any).id = token.id
//       return Promise.resolve(session)
//     },
//   },
// })

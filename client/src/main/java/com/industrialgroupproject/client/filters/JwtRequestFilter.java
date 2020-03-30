package com.industrialgroupproject.client.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.industrialgroupproject.client.Utils.JwtUtil;
import com.industrialgroupproject.client.servive.UserDetailsServiceImpl;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	private final String AUTHORIZATION_HEADER = "Bearer ";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");

		String userName = null;
		String jwt = null;

		if((authorizationHeader != null) && authorizationHeader.startsWith(this.AUTHORIZATION_HEADER)) {
			jwt = authorizationHeader.substring(this.AUTHORIZATION_HEADER.length());
			userName = this.jwtTokenUtil.extractUsername(jwt);
		}

		if((userName != null) && (SecurityContextHolder.getContext().getAuthentication() == null)) {
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
			if(this.jwtTokenUtil.validateToken(jwt, userDetails)) {
				final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		filterChain.doFilter(request, response);

	}



}

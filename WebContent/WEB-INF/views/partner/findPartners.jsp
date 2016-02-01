l<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
				<main class="main">
				 <form action="partnerList" method="get" > <!-- 서브밋한거 페이지 이리로 넘어감 -->
					<h2>FInd! your partner</h2>
					<table>
						<thead>
							<tr>
								<td>Country</td>
								<td>Native Language</td>
								<td>Learning Language</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><legend>Nationality</legend>
									<select name="nc">
										<option value="All" >All</option>
										<c:forEach var="p" items="${countryList}">
											<option value="${p.country}">"${p.country}"</option>
										</c:forEach>
									</select>
								</td>	
								<td><legend>Native</legend>
									<select name="nl">
										<option value="All" >All</option>
										<c:forEach var="p" items="${languageList}">
										<option value="${p.language}">"${p.language}"</option>
										</c:forEach>
									</select>
								</td>
								<td><legend>Learning</legend>
									<select name="ll">
										<option value="All" >All</option>
										<c:forEach var="p" items="${languageList}">
										<option value="${p.language}">"${p.language}"</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							
							<tr>
								<td><legend>Habitation</legend>
									<select name="hc"><!-- name으로 넘겨줘 -->
										<option value="All" >All</option>
										<c:forEach var="p" items="${countryList}">
											<option value="${p.country}">"${p.country}"</option>
										</c:forEach>
									</select>
								</td>
								<td><legend>MentorLV</legend>
									<select name="mentorLV">
										<option value="All">All</option>
										<option value="Beginner">Beginner</option>
										<option value="Intermediate">Intermediate</option>
										<option value="Advenced">Advenced</option>
									</select>
								</td>
								<td><legend>MenteeLV</legend>
									<select name="menteeLV">
										<option value="All">All</option>
										<option value="Beginner">Beginner</option>
										<option value="Intermediate">Intermediate</option>
										<option value="Advenced">Advenced</option>
									</select>
								</td>
							</tr>
							<!-- 서브밋으로 하면 위에 name값들 그대로 컨트롤러로 넘길수잇다 -->
							<!-- <a class="btn-search button" href="partnerList">검색</a> -->
						</tbody>
					</table>
					<input type="submit"  value="검색"> 
					</form>
				</main>

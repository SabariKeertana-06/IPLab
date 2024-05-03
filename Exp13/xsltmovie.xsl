<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Movie Ratings</title>
        <style>
          .highlight {
            background-color: yellow;
          }
        </style>
      </head>
      <body>
        <h1>Movie Ratings</h1>
        <table border="1">
          <tr>
            <th>Title</th>
            <th>Director</th>
            <th>Rating</th>
          </tr>
          <xsl:apply-templates select="movies/movie"/>
        </table>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="movie">
    <xsl:if test="rating &gt;= 8">
      <tr>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="director"/></td>
        <td class="highlight"><xsl:value-of select="rating"/></td>
      </tr>
    </xsl:if>
    <xsl:if test="rating &lt; 8">
      <tr>
        <td><xsl:value-of select="title"/></td>
        <td><xsl:value-of select="director"/></td>
        <td><xsl:value-of select="rating"/></td>
      </tr>
    </xsl:if>
  </xsl:template>
</xsl:stylesheet>

